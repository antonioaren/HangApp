package es.ulpgc.eite.clean.mvp.sample;

import android.support.test.espresso.contrib.PickerActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.widget.TimePicker;

import junit.framework.Assert;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;

import es.ulpgc.eite.clean.mvp.sample.addCategory.AddCategoryModel;
import es.ulpgc.eite.clean.mvp.sample.category.CategoryModel;
import es.ulpgc.eite.clean.mvp.sample.category.CategoryView;
import io.realm.Realm;
import io.realm.RealmConfiguration;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.doubleClick;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by eleonora on 24/05/2017.
 */

public class EspressoTest {


    @Rule
    public final ActivityTestRule<CategoryView> presenter = new ActivityTestRule<>(CategoryView.class);


    @Test
    public void testOnAddClickedFromMainScreen() {

        onView(withId(R.id.fButtonAddCategory)).perform(click());
        onView(withId(R.id.textPhoto)).check(matches(isDisplayed()));
        onView(withId(R.id.textName)).check(matches(isDisplayed()));
        onView(withId(R.id.radioGroup)).check(matches(isDisplayed()));
        onView(withId(R.id.content_name)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonAddCategory)).check(matches(isDisplayed()));
    }

    @Test
    public void testOnAddClickeFromAddCategoryScreen() {
        //funciona
        //the test starts at main screen
        onView(withId(R.id.fButtonAddCategory)).perform(click());
        onView(withId(R.id.buttonAddCategory)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonAddCategory)).perform(click());

        onView(withId(R.id.recycler)).check(matches(isDisplayed()));
    }


    @Test
    public void testClickingAnItemAtSpecificPositionInRecyclerView() throws Exception {
        //funciona
        onView(withId(R.id.recycler))
                // Click item at position 3
                .perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
        onView(withId(R.id.fButtonAddProduct)).check(matches(isDisplayed()));


    }

    @Test
    public void insertCategoryFromAddScreen() {
        //funciona

        onView(withId(R.id.fButtonAddCategory)).perform(click());
        // Types a message into a EditText element.
        onView(withId(R.id.content_name))
                .perform(typeText("Fiestas"), closeSoftKeyboard());

        // Clicks a button to send the message to another
        // activity through an explicit intent.
        onView(withId(R.id.buttonAddCategory)).perform(click());
        onView(withText("Fiestas")).check(matches(isDisplayed()));
        // Verifies that the DisplayMessageActivity received an intent
        // with the correct package name and message.

    }

    @Test
    public void testRemoveElementWhenApplicationStarted() throws Exception {

        onView(withId(R.id.recycler)).perform(RecyclerViewActions.actionOnItemAtPosition(0, swipeLeft()));

        onView(withText("Automovilismo")).check(matches(isDisplayed()));
        onView(withText("Música")).check(matches(isDisplayed()));
        onView(withText("ULPGC")).check(matches(isDisplayed()));


    }


    @Test
    public void testInsertingANewPartyInACategory() throws Exception {
        //funciona
        int hour = 20;
        int minutes = 20;
        String name = "1";

        onView(withId(R.id.recycler))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.fButtonAddProduct)).perform(click());
        onView(withId(R.id.name))
                // Types a message into a EditText element.
                .perform(typeText(name), closeSoftKeyboard());
        onView(withId(R.id.place))
                .perform(typeText("tokyo"), closeSoftKeyboard());

        onView(withId(R.id.date)).perform(doubleClick());
        // onView(isAssignableFrom(DatePicker.class)).perform(setDate(2017, 10, 30));
//        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(setDate(year, month, day));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.timeI)).perform(click()).perform(click());
        onView(withClassName(Matchers.equalTo(TimePicker.class.getName()))).perform(PickerActions.
                setTime(hour, minutes));

        onView(withText("OK")).perform(click());

        onView(withId(R.id.TimeF))
                .perform(click()).perform(click());

        onView(withClassName(Matchers.equalTo(TimePicker.class.getName()))).perform(
                PickerActions.setTime(hour, minutes));
        onView(withText("OK")).perform(click());

        onView(withId(R.id.imageButton)).perform(click());
        // Create a bitmap we can use for our simulated camera image
        // Create a bitmap we can use for our simulated camera image
      /*  Bitmap icon = BitmapFactory.decodeResource(
                InstrumentationRegistry.getTargetContext().getResources(),
                R.mipmap.ic_launcher);

        // Build a result to return from the Camera app
        Intent resultData = new Intent();
        resultData.putExtra("data", icon);
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);

        // Stub out the Camera. When an intent is sent to the Camera, this tells Espresso to respond
        // with the ActivityResult we just created*/


        // Now that we have the stub in place, click on the button in our app that launches into the Camera
        onView(withId(R.id.imageButton)).perform(click());

        // We can also validate that an intent resolving to the "camera" activity has been sent out by our app


        // Clicks a button to send the message to another
        // activity through an explicit intent.
        onView(withId(R.id.addParty)).perform(click());
        // Verifies that the DisplayMessageActivity received an intent
        // with the correct package name and message.

        onView(withText(name)).check(matches(isDisplayed()));


    }

    @Test
    public void testGoToDetailScreenOfAParty() throws Exception {
        testInsertingANewPartyInACategory();
        onView(withText("1")).perform(click());
        onView(withId(R.id.EventName)).check(matches(isDisplayed()));
        onView(withText("1")).check(matches(isDisplayed()));
        onView(withId(R.id.detail)).check(matches(isDisplayed()));
        onView(withId(R.id.headerPlace)).check(matches(isDisplayed()));
        onView(withId(R.id.headerDate)).check(matches(isDisplayed()));
        onView(withId(R.id.headerTimeInit)).check(matches(isDisplayed()));
        onView(withId(R.id.headerTimeEnd)).check(matches(isDisplayed()));
    }


    @Test
    public void insertEventTestBeforeStartingApplication() {
        //la unica manera para que funcione es que el acceso a RealmOPeration sea publico, pero viola las caracteristicas del singleton
        final AddCategoryModel add = new AddCategoryModel();
        RealmConfiguration testConfig =
                new RealmConfiguration.Builder().
                        inMemory().
                        name("test-realm1").build();

        Realm testRealm = Realm.getInstance(testConfig);
        // RealmOperation realm=  new RealmOperation();

        //   realm.insertEventCategory("sdfghj","disco.jpg");
        //  Assert.assertEquals(4,realm.getCategoryEvents().size());

                                         }


    //comprobacion del test con un metodo


    @Test
    public void deleteEvent() {
        //funciona
        final CategoryModel c = new CategoryModel();
        // c.CreateDatabaseTables();

        RealmConfiguration testConfig =
                new RealmConfiguration.Builder().
                        inMemory().
                        name("test-realm1").build();

        Realm testRealm = Realm.getInstance(testConfig);

        testRealm.executeTransaction(new Realm.Transaction() {
                                         @Override
                                         public void execute(Realm realm) {


                                             c.insertEvent("jkhkih", "disco.jpg");
                                             c.insertEvent("jjh", "disco.jpg");
                                             String idLastElement = c.getId();
                                             c.deleteItem(idLastElement);
                                         }
                                     }
        );
        //comprobacion del test con un metodo
        Assert.assertEquals(6, c.getNumberOfCategories());

    }

    @Test
    public void testGetFirstElementName() {
        CategoryModel category = new CategoryModel();
        // category.CreateDatabaseTables();
        Assert.assertEquals("Fiestas", category.getCategoryEvents().first().getCategoryName());
    }

    @Test
    public void testGetLastElementName() {
        CategoryModel category = new CategoryModel();
        // category.CreateDatabaseTables();

        Assert.assertEquals("Automovilismo", category.getCategoryEvents().last().getCategoryName());
    }
    @Test
    public void getNumberOfCategories() {

        final CategoryModel c = new CategoryModel();

        RealmConfiguration testConfig =
                new RealmConfiguration.Builder().
                        inMemory().
                        name("test-realmCategories").build();

        Realm testRealm = Realm.getInstance(testConfig);
        testRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                // c.CreateDatabaseTables();


            }
        });
        //comprobacion del test con un metodo
        Assert.assertEquals(5, c.getCategoryEvents().size());
    }
}

