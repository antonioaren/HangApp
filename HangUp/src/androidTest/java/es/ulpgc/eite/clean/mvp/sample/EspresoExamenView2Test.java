package es.ulpgc.eite.clean.mvp.sample;

import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import es.ulpgc.eite.clean.mvp.sample.examenScreen2.ExamenScreenView2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Pedro Arenas on 12/7/17.
 */

public class EspresoExamenView2Test {
    @Rule
    public final ActivityTestRule<ExamenScreenView2> presenter = new ActivityTestRule<>(ExamenScreenView2.class);

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void checkIfElementsOnView() {
        onView(withId(R.id.registerlabel)).check(matches(isDisplayed()));
        onView(withId(R.id.numberRegistersDB)).check(matches(isDisplayed()));
    }

    @Test
    public void checkInitializationNumber() {
        //5 son los elementos de la lista.
        onView(withText("5")).check(matches(isDisplayed()));
    }
}
