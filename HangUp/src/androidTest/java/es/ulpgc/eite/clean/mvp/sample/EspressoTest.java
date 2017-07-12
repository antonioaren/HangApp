package es.ulpgc.eite.clean.mvp.sample;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import es.ulpgc.eite.clean.mvp.sample.category.CategoryView;
import es.ulpgc.eite.clean.mvp.sample.realmoperation.RealmOperation;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by eleonora on 24/05/2017.
 */

public class EspressoTest {
    private RealmOperation realmOperation;

    @Rule
    public final ActivityTestRule<CategoryView> presenter = new ActivityTestRule<>(CategoryView.class);

    public EspressoTest() {
        realmOperation = new RealmOperation();
    }

    @Before
    public void setUp() throws Exception {
        realmOperation.deleteAllDatabase();
        realmOperation.createDatabaseDefault();
    }

    @Test
    public void testOnAddClickedFromMainScreen() {
        //test funciona con android studio actualizado;
        onView(withId(R.id.fButtonAddCategory)).perform(click());
        onView(withId(R.id.textPhoto)).check(matches(isDisplayed()));
        onView(withId(R.id.textName)).check(matches(isDisplayed()));
        onView(withId(R.id.radioGroup)).check(matches(isDisplayed()));
        onView(withId(R.id.content_name)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonAddCategory)).check(matches(isDisplayed()));
    }
    @Test
    public void testClickingAnItemAtSpecificPositionInRecyclerView() throws Exception {
        onView(withId(R.id.recycler))                // Click item at position 4
                .perform(RecyclerViewActions.actionOnItemAtPosition(4, click()));
        onView(withId(R.id.fButtonAddProduct)).check(matches(isDisplayed()));
    }

    @Test
    public void testRemoveElementWhenApplicationStarted() throws Exception {
        onView(withId(R.id.recycler)).perform(RecyclerViewActions.actionOnItemAtPosition(1, swipeLeft()));
        Assert.assertEquals(4, realmOperation.getCategoryEvents().size() - 1);
    }

    ///////////////////////////////////DATABASE/////////////////////////////////////////////////////

    @Test
    public void testGetFirstElementName() {
        Assert.assertEquals("Fiestas", realmOperation.getCategoryEvents().first().getCategoryName());
    }

    @Test
    public void testGetLastElementName() {
        Assert.assertEquals("Automovilismo", realmOperation.getCategoryEvents().last().getCategoryName());
    }

    //Examen test
    @Test
    public void goToAuthorScreen() throws Exception {
        onView(withId(R.id.fButtonAddCategory)).perform(click());
        onView(withId(R.id.AutoresBTn)).perform(click());
        onView(withId(R.id.textAuthors)).check(matches(isDisplayed()));
        onView(withId(R.id.imageAuthors)).check(matches(isDisplayed()));
        onView(withText("Authors: Eleonora de ferra chermaz y pedro Antonio Arenas Lara")).check(matches(isDisplayed()));
        
    }

}

