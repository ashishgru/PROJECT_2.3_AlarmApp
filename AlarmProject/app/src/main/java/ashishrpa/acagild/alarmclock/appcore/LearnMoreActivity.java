
package ashishrpa.acagild.alarmclock.appcore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import ashishrpa.acagild.alarmclock.R;
import ashishrpa.acagild.alarmclock.utilities.Loggable;
import ashishrpa.acagild.alarmclock.utilities.Logger;
import ashishrpa.acagild.alarmclock.utilities.GeneralUtilities;

/**
 * This class hosts the learn more/help experience for the application.  It is invoked from the
 * options menu.
 */
public class LearnMoreActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_more);

        Toolbar bar = (Toolbar) findViewById(R.id.learn_more_toolbar);
        setSupportActionBar(bar);

        LinearLayout linksHolder = (LinearLayout) findViewById(R.id.learn_more_links);
        for( int i = 0; i < linksHolder.getChildCount(); i++ ) {
            TextView child = (TextView) linksHolder.getChildAt(i);
            GeneralUtilities.enableLinks(child);
        }

        Logger.init(this);
        Loggable.UserAction userAction = new Loggable.UserAction(Loggable.Key.ACTION_LEARN_MORE);
        Logger.track(userAction);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.flush();
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
