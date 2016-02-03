package com.demo.raj.listofitems;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by raj on 2/4/2016.
 */
public class ItemsFragment extends Fragment {

    // TAG for debugging
    private static final String LOG_TAG = ItemsFragment.class.getSimpleName();

    // Our items ListView
    private ListView mListView;

    // progress bar
    private ProgressBar mProgressBar;

    // empty list view
    private TextView mEmptyView;

    // default constructor
    public ItemsFragment(){}

    @Override
    public void onStart() {
        super.onStart();

        // Start fetching the items
        ItemsFetchTask task = new ItemsFetchTask();
        task.execute();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_items, container, false);

        mListView = (ListView)rootView.findViewById(R.id.items_list);

        mProgressBar = (ProgressBar)rootView.findViewById(R.id.progress_bar);

        mEmptyView = (TextView)rootView.findViewById(R.id.empty);

        return rootView;
    }

    // AsyncTask to fetch the items over network
    class ItemsFetchTask extends AsyncTask<Void, Integer, List<Item>>{

        // This will have the json of items
        String itemsJson = null;

        // url to fetch for the items
        private static final String URL = "https://gist.githubusercontent.com/maclir/f715d78b49c3b4b3b77f/raw/8854ab2fe4cbe2a5919cea97d71b714ae5a4838d/items.json";
        @Override
        protected List<Item> doInBackground(Void... params){

            List<Item> result = null;

            // http client
            OkHttpClient client = new OkHttpClient();

            // http request
            Request request = new Request.Builder()
                    .url(URL)
                    .build();

            // response object
            Response response = null;
            try {
                response = client.newCall(request).execute();

                if(response != null){
                    itemsJson = response.body().string();

                    // parse the json data
                    result = parseItemsJson(itemsJson);
                }
                else{
                    Log.v(LOG_TAG, "No Data received.");
                }
            }catch(IOException e){
                Log.v(LOG_TAG, "Problem in fetching list items.");
                e.printStackTrace();
            }
            catch(JSONException e){
                Log.v(LOG_TAG, "Error in json parsing");
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(List<Item> s) {
        }
    }

    /**
     * Parses the json data
     * @param json unparsed items data in json format
     * @return ArrayList<Item> list of items
     * @throws JSONException
     */
    private List<Item> parseItemsJson(String json) throws JSONException{
        List<Item> itemsList = new ArrayList<Item>();

        // names of important json objects to be extracted
        final String IMAGE = "image";
        final String DESC = "description";
        final String TITLE = "title";

        JSONArray jsonArray = new JSONArray(json);

        for(int i=0; i<jsonArray.length(); i++)
        {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String url = jsonObject.getString(IMAGE);
            String desc = jsonObject.getString(DESC);
            String title = jsonObject.getString(TITLE);

            Item item = new Item(title, desc, url);
            itemsList.add(item);
        }
        return itemsList;
    }
}
