
import android.content.Context;
import android.util.Log;

import com.udacity.gradle.builditbigger.BuildConfig;
import com.udacity.gradle.builditbigger.JokesEndPointAsyncTask;
import com.udacity.gradle.builditbigger.MainActivity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by abdel on 12/26/2017.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class,sdk = 21)
public class AsyncTaskConnctedTest {

    @Test
    public void testAsync() throws Exception{

        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Robolectric.flushBackgroundThreadScheduler();

        Assert.assertNotEquals(activity.getJoke(),"");
    }
}
