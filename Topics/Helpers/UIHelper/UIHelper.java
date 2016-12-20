package it.negusweb.starterkit.classes.helper;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;


/**
 UIHelper
 @author Fabrizio Caldarelli
 @version 1
 */
public class UIHelper {
 
    // Show waiter
    public static ProgressDialog showWaiter(Context ctx) { return showWaiter(ctx, null); }
    public static ProgressDialog showWaiter(Context ctx, String message)
    {
        String msg = (message!=null)?message: ctx.getString(R.string.uihelper_waiter_default_message);

        ProgressDialog pd = new ProgressDialog(ctx);
        pd.setMessage(msg);
        pd.setIndeterminate(true);
        pd.setCancelable(false);
        pd.setCanceledOnTouchOutside(false);
        pd.show();
        return pd;
    }

    // Hide waiter
    public static void hideWaiter(ProgressDialog pd)
    {
        try {
            if (pd != null) {
                pd.hide();
                pd.dismiss();
            }
        }
        catch(Exception excp)
        {

        }
        pd = null;
    }

    // ShowAlertOK
    public static AlertDialog showAlertOK(Context ctx, String title, String message, DialogInterface.OnClickListener okTapped)
    {
        AlertDialog ad = new AlertDialog.Builder(ctx)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.uihelper_alertok_ok, okTapped)
                .create();

        ad.show();

        return ad;
    }


}
