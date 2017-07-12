package es.ulpgc.eite.clean.mvp.sample;

import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import es.ulpgc.eite.clean.mvp.sample.examenScreen1.ExamenScreenView1;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Pedro Arenas on 12/7/17.
 */

public class EspressoExamenView1Tests {

    @Rule
    public final ActivityTestRule<ExamenScreenView1> presenter = new ActivityTestRule<>(ExamenScreenView1.class);

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void checkIfElementsOnView() {
        onView(withId(R.id.nombre1)).check(matches(isDisplayed()));
        onView(withId(R.id.nombre2)).check(matches(isDisplayed()));
    }

    @Test
    public void checkNames() {
        onView(withText("Pedro Arenas")).check(matches(isDisplayed()));
        onView(withText("Eleonora Ferraz")).check(matches(isDisplayed()));
    }

    @Test
    public void ImagenOnView() {
        onView(withId(R.id.imagenexamen)).check(matches(isDisplayed()));
    }
}
