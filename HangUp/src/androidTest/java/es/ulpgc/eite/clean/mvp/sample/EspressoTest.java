package es.ulpgc.eite.clean.mvp.sample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.ulpgc.eite.clean.mvp.sample.category.CategoryModel;
import es.ulpgc.eite.clean.mvp.sample.category.CategoryView;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.delete.DeleteModel;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by eleonora on 24/05/2017.
 */
@RunWith(AndroidJUnit4.class)
public class EspressoTest  {
    private static final String MESSAGE = "This is a test";
    private static final String PACKAGE_NAME = "es.ulpgc.eite.clean.mvp.sample";

    @Rule public final ActivityTestRule<CategoryView> presenter= new ActivityTestRule<>(CategoryView.class);
    @Before
    public void setup() {

    }


    @Test
    public void shouldBeAbleToLaunchMainScreen(){
        onView(withId(R.id.buttonAdd)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonSearch)).check(matches(isDisplayed()));



    }
     @Test
    public void testOnAddClickedFromMainScreen(){
         onView(withId(R.id.buttonAdd)).perform(click());
     //actualizando test
         onView(withId(R.id.textPhoto)).check(matches(isDisplayed()));
         onView(withId(R.id.textName)).check(matches(isDisplayed()));
         onView(withId(R.id.radioGroup)).check(matches(isDisplayed()));
         onView(withId(R.id.content_name)).check(matches(isDisplayed()));
         onView(withId(R.id.buttonAdd2)).check(matches(isDisplayed()));
     }
    @Test
    public void testOnSearchCliked()throws Exception{
        onView(withId(R.id.buttonSearch)).perform(click());
        onView(withId(R.id.delete)).check(matches(isDisplayed()));
        onView(withId(R.id.deleteId)).check(matches(isDisplayed()));
        onView(withId(R.id.text)).check(matches(isDisplayed()));
        onView(withId(R.id.text2)).check(matches(isDisplayed()));
        onView(withId(R.id.editText)).check(matches(isDisplayed()));
        onView(withId(R.id.editText2)).check(matches(isDisplayed()));

    }
    @Test
    public void testOnAddClickeFromAddCategoryScreen(){
      //the test starts at main screen
       onView(withId(R.id.buttonAdd)).perform(click());
        onView(withId(R.id.buttonAdd2)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonAdd2)).perform(click());
        //actualizando test

        onView(withId(R.id.recycler)).check(matches(isDisplayed()));

        onView(withId(R.id.buttonSearch)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonAdd)).check(matches(isDisplayed()));
    }



    @Test
    public void verifyMessageSentToMainActivity() {


        onView(withId(R.id.buttonAdd)).perform(click());
        // Types a message into a EditText element.
        onView(withId(R.id.content_name))
                .perform(typeText(MESSAGE), closeSoftKeyboard());

        // Clicks a button to send the message to another
        // activity through an explicit intent.
        onView(withId(R.id.buttonAdd2)).perform(click());
        onView(withText(MESSAGE)).check(matches(isDisplayed()));
        // Verifies that the DisplayMessageActivity received an intent
        // with the correct package name and message.

    }
  @Test
    public void insertEventTestBeforeStartingApplication(){
    final  CategoryModel c= new CategoryModel();
      RealmConfiguration testConfig =
              new RealmConfiguration.Builder().
                      inMemory().
                      name("test-realm").build();

      Realm testRealm = Realm.getInstance(testConfig);

     testRealm.executeTransaction(new Realm.Transaction() {
         @Override
         public void execute(Realm realm) {
             c.insertEvent("jgbugb",R.drawable.astro);
         }
     });
  }

    @Test
    public void DeleteEventTest()throws Exception{
        final DeleteModel search = new DeleteModel();
        RealmConfiguration testConfig =
                new RealmConfiguration.Builder().
                        inMemory().
                        name("test-realm").build();

        Realm testRealm = Realm.getInstance(testConfig);

        testRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                search.deteleEvent("Música");

            }
        });
    }

    @Test
    public void SearchEventTest() throws Exception {

        RealmConfiguration testConfig =
                new RealmConfiguration.Builder().
                        inMemory().
                        name("test-realm").build();

        Realm testRealm = Realm.getInstance(testConfig);

        testRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<CategoryData> pups = realm.where(CategoryData.class)
                        .equalTo("CategoryName", "Música")
                        .equalTo("CategoryName", "Fiestas")
                        .equalTo("CategoryName", "Astronomía")
                        .equalTo("CategoryName", "ULPGC")
                        .findAll();

            }
        });
    }
}

