package com.demo.raj.listofitems;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;

/**
 * A utility class that contains common utility methods
 *
 * Created by raj on 2/4/2016.
 */
public class Utils {

    /**
     * Detects if the user is connected to the internet or not
     * @param ctx Context of the app
     * @return true if user is connected to internet, false otherwise
     */
    public static boolean isConnected(Context ctx){
        boolean isConnected = false;

        ConnectivityManager cm = (ConnectivityManager)ctx.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo nwInfo = cm.getActiveNetworkInfo();

        if(nwInfo != null)
        {
            isConnected = nwInfo.isConnectedOrConnecting();
        }
        return isConnected;
    }

    /**
     * Shows a dialog with OK button on it
     * @param ctx context of the app
     */
    public static void showNetworkDialog(Context ctx ){

        AlertDialog.Builder dlg = new AlertDialog.Builder(ctx);
                dlg.setTitle(R.string.dlg_title)
                .setMessage(R.string.dlg_msg)
                .setPositiveButton(R.string.dlg_ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .create().show();
    }
}
