package it.negusweb.starterkit.classes.helper;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;


/**
 UIHelper
 @author Fabrizio Caldarelli
 @version 2
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

    public static AlertDialog showAlertYesNo(Context ctx, String title, String message, final UIHelperAlertYesNoListener listener)
    {
        AlertDialog ad = new AlertDialog.Builder(ctx)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.uihelper_alertok_yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(listener!=null) listener.uiHelperAlertYesNoResponse(true);
                    }
                })
                .setPositiveButton(R.string.uihelper_alertok_no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(listener!=null) listener.uiHelperAlertYesNoResponse(false);
                    }
                })
                .create();

        ad.show();

        return ad;
    }

    public interface UIHelperAlertYesNoListener
    {
        void uiHelperAlertYesNoResponse(boolean response);
    }
}

