package apps.buddy.myapptabbed.parse;

import android.content.Context;
import android.content.Intent;

import com.parse.ParsePushBroadcastReceiver;

import apps.buddy.myapptabbed.activities.MainActivity;
import apps.buddy.myapptabbed.utils.QLog;


/**
 * @author Gaurav Gupta <gaurav@thegauravgupta.com>
 * @since 24/Dec/2014
 */

public class NotificationReceiver extends ParsePushBroadcastReceiver {

    @Override
    public void onPushOpen(Context context, Intent intent) {
        QLog.v("Push Clicked");
        Intent i = new Intent(context, MainActivity.class);
        i.putExtras(intent.getExtras());
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}