import com.udacity.gradle.builditbigger.BuildConfig;
import com.udacity.gradle.builditbigger.MainActivity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by abdel on 1/18/2018.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class,sdk = 21)
public class TempTestV2 {

    @Test
    public void testAsync() throws Exception{

        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Robolectric.flushBackgroundThreadScheduler();

        Assert.assertEquals(activity.getJoke(),"");
    }
}
