package es.ulpgc.eite.clean.mvp.sample;

import android.support.test.rule.ActivityTestRule;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


import es.ulpgc.eite.clean.mvp.sample.category.CategoryView;
import es.ulpgc.eite.clean.mvp.sample.realmoperation.RealmOperation;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Pedro Arenas on 12/7/17.
 */

public class EspresoExamenCategoryTest {

    @Rule
    public final ActivityTestRule<CategoryView> presenter = new ActivityTestRule<>(CategoryView.class);


    @Before
    public void setUp() {

    }

    @Test
    public void testDBItems() {
        RealmOperation realmOperation = RealmOperation.getInstances();
        Assert.assertEquals(5, realmOperation.getCategoryEvents().size());
    }

    @Test
    public void buttonIsOnView() {
        onView(withId(R.id.examen)).check(matches(isDisplayed()));
    }

    @Test
    public void buttonClick() {
        onView(withId(R.id.examen)).perform(click());

    }
}
