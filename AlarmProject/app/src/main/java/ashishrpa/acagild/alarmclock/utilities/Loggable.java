

package ashishrpa.acagild.alarmclock.utilities;



import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class Loggable {
    public String Name;
    JSONObject Properties;

    public void putProp(String property, Object value) {
        try {
            Properties.put(property, value);
        }
        catch (JSONException ex) {
            Logger.trackException(ex);
        }
    }

    public void putJSON(JSONObject json) {
        try {
            Iterator<?> keys = json.keys();

            while( keys.hasNext() ) {
                String key = (String)keys.next();
                Properties.put(key, json.get(key));
            }
        }
        catch (JSONException ex) {
            Logger.trackException(ex);
        }
    }


    public interface Key {
        String APP_ALARM_RINGING = "An alarm rang";
        String APP_EXCEPTION = "Exception caught";
        String APP_ERROR = "Error occurred";
        String APP_API_VISION = "Calling Vision API";
        String APP_API_EMOTION = "Calling Emotion API";
        String APP_API_SPEECH = "Calling Speech API";

        String ACTION_ALARM_SNOOZE = "Snoozed an alarm";
        String ACTION_ALARM_DISMISS = "Dismissed an alarm";
        String ACTION_ALARM_EDIT = "Editing an alarm";
        String ACTION_ALARM_CREATE = "Creating a new alarm";
        String ACTION_ALARM_SAVE = "Saving changes to an alarm";
        String ACTION_ALARM_SAVE_DISCARD = "Discarding changes to an alarm";
        String ACTION_ALARM_DELETE = "Deleting an alarm";

        String ACTION_GAME_COLOR = "Played a color finder game";
        String ACTION_GAME_COLOR_FAIL = "Failed a color finder game";
        String ACTION_GAME_COLOR_TIMEOUT = "Timed out on a color finder game";
        String ACTION_GAME_COLOR_SUCCESS = "Finished a color finder game";

        String ACTION_GAME_TWISTER = "Played a tongue twister game";
        String ACTION_GAME_TWISTER_FAIL = "Failed a tongue twister game";
        String ACTION_GAME_TWISTER_TIMEOUT = "Timed out on a tongue twister game";
        String ACTION_GAME_TWISTER_SUCCESS = "Finished a tongue twister game";

        String ACTION_GAME_EMOTION = "Played an emotion game";
        String ACTION_GAME_EMOTION_FAIL = "Failed an emotion game";
        String ACTION_GAME_EMOTION_TIMEOUT = "Timed out on an emotion game";
        String ACTION_GAME_EMOTION_SUCCESS = "Finished an emotion game";

        String ACTION_GAME_NONETWORK = "Played an no network game";
        String ACTION_GAME_NONETWORK_TIMEOUT = "Timed out on an no network game";
        String ACTION_GAME_NONETWORK_SUCCESS = "Finished an no network game";

        String ACTION_ONBOARDING = "Started onboarding";
        String ACTION_ONBOARDING_SKIP = "Skipped onboarding";
        String ACTION_ONBOARDING_TOS_ACCEPT = "Accepted ToS";
        String ACTION_ONBOARDING_TOS_DECLINE = "Declined ToS";

        String ACTION_LEARN_MORE = "Reading Learn More";

        String ACTION_SHARE = "Sharing";

        String PROP_QUESTION = "Question";
        String PROP_DIFF = "Difference";
    }

    public static class UserAction extends Loggable {
        public UserAction (String name) {
            Name = name;
            Properties = new JSONObject();
            try {
                Properties.put("Type", "User Action");
            }
            catch (JSONException jsonEx) {
            }
        }
    }

    public static class AppAction extends Loggable {
        public AppAction (String name) {
            Name = name;
            Properties = new JSONObject();
            try {
                Properties.put("Type", "App Action");
            }
            catch (JSONException jsonEx) {
            }
        }
    }

    public static class AppException extends Loggable {
        public AppException (String name, Exception ex) {
            Name = name;
            Properties = new JSONObject();
            try {
                Properties.put("Type", "Exception");
                Properties.put("Message", ex);
                Properties.put("Detailed Message", ex.getMessage());
            }
            catch (JSONException jsonEx) {
            }
        }
    }

    public static class AppError extends Loggable {
        public AppError (String name, String error) {
            Name = name;
            Properties = new JSONObject();
            try {
                Properties.put("Type", "Error");
                Properties.put("Message", error);
            }
            catch (JSONException jsonEx) {
            }
        }
    }
}
