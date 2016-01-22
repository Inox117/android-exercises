package fr.android.androidexercises;

import junit.framework.TestCase;

import org.assertj.android.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.shadows.ShadowToast;

@RunWith(CustomRobolectricTestRunner.class)
public class LoginActivityTest extends TestCase {

    LoginActivity activity;
    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(LoginActivity.class);
    }

    @Test
    public void should_logged() throws Exception {
        // Given
        // When
        activity.logged();
        // Then
        Assertions.assertThat(activity.loginLayout).isGone();
        Assertions.assertThat(activity.loggedText).isVisible();
    }

    public void testOnCreate() throws Exception {
    }

    @Test
    public void testOnResume() throws Exception {
        activity.onResume();
        Assertions.assertThat(activity.loginLayout).isNotGone();
        Assertions.assertThat(activity.loggedText).isNotVisible();
    }

    @Test
    public void testNotLogged() throws Exception {
        activity.notLogged();
        Assertions.assertThat(activity.loginLayout).isNotGone();
        Assertions.assertThat(activity.loggedText).isNotVisible();
    }

    @Test
    public void testMessage() throws Exception {
        activity.message(R.string.text_logged);
        String text = ShadowToast.getTextOfLatestToast();
        org.assertj.core.api.Assertions.assertThat(text).isEqualTo("Your are logged in");
    }
}