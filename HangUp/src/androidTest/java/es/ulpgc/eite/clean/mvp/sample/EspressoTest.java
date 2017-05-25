package es.ulpgc.eite.clean.mvp.sample;

import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.ulpgc.eite.clean.mvp.sample.category.CategoryView;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by eleonora on 24/05/2017.
 */
@RunWith(AndroidJUnit4.class)
public class EspressoTest  {

    @Rule public final ActivityTestRule<CategoryView> presenter= new ActivityTestRule<>(CategoryView.class);
    @Test
    public void shouldBeAbleToLaunchMainScreen(){
//        onView(withId(R.id.buttonAdd)).perform(click());
//         onView(withId(R.id.textName)).check(matches(ViewMatchers.isDisplayed()));
       // onView(withId(R.id.title)).check(matches(ViewMatchers.isDisplayed()));
        onView(withId(R.id.title)).check((ViewAssertion) ViewMatchers.isDisplayed());
    }
     @Test
    public void testOnAddClickedFromMainScreen(){
         onView(withId(R.id.buttonAdd)).perform(click());
     //actualizando test
         onView(withId(R.id.textPhoto)).check(matches(ViewMatchers.isDisplayed()));
         onView(withId(R.id.textName)).check(matches(ViewMatchers.isDisplayed()));
         onView(withId(R.id.radioGroup)).check(matches(ViewMatchers.isDisplayed()));
         onView(withId(R.id.content_name)).check(matches(ViewMatchers.isDisplayed()));
         onView(withId(R.id.buttonAdd)).check(matches(ViewMatchers.isDisplayed()));
     }
    @Test
    public void testOnSearchCliked()throws Exception{
        onView(withId(R.id.buttonSearch)).perform(click());
        onView(withId(R.id.delete)).check(matches(ViewMatchers.isDisplayed()));
        onView(withId(R.id.deleteId)).check(matches(ViewMatchers.isDisplayed()));
        onView(withId(R.id.text)).check(matches(ViewMatchers.isDisplayed()));
        onView(withId(R.id.text2)).check(matches(ViewMatchers.isDisplayed()));
        onView(withId(R.id.editText)).check(matches(ViewMatchers.isDisplayed()));
        onView(withId(R.id.editText2)).check(matches(ViewMatchers.isDisplayed()));

    }
    @Test
    public void testOnAddClickeFromAddCategoryScreen(){

        onView(withId(R.id.buttonAdd2)).perform(click());
        //actualizando test
        onView(withId(R.id.title)).check(matches(ViewMatchers.isDisplayed()));
        onView(withId(R.id.recycler)).check(matches(ViewMatchers.isDisplayed()));
        onView(withId(R.id.image)).check(matches(ViewMatchers.isDisplayed()));
        onView(withId(R.id.buttonSearch)).check(matches(ViewMatchers.isDisplayed()));
        onView(withId(R.id.buttonAdd)).check(matches(ViewMatchers.isDisplayed()));
    }


}
