package es.ulpgc.eite.clean.mvp.sample;

import org.junit.Test;

import java.io.IOException;

import es.ulpgc.eite.clean.mvp.sample.addCategory.AddCategoryModel;
import es.ulpgc.eite.clean.mvp.sample.authors.AuthorsModel;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


  @Test
public void testGetImageByIdSelected() throws Exception {
  AddCategoryModel add = new AddCategoryModel();
  assertEquals("cars.jpeg", add.getImageByIdSelected(3));

}


  @Test
  public void testGetImageByIdSelectedOutOfRange() throws Exception {
    AddCategoryModel add = new AddCategoryModel();
    String index = add.getImageByIdSelected(-1);
    assertEquals(null, index);

  }

  @Test
  public void secondTestGetImageByIdSelectedOutOfRange() throws Exception {
    AddCategoryModel add = new AddCategoryModel();
    String index = add.getImageByIdSelected(5);
    assertEquals(null, index);

  }

  @Test
  public void testGetRadioLabels() throws Exception {
    AddCategoryModel add = new AddCategoryModel();
    assertEquals("Astro", add.getLabelRadio0());
    assertEquals("Academic", add.getLabelRadio1());
    assertEquals("Car", add.getLabelRadio2());
    assertEquals("Disco", add.getLabelRadio3());
  }


  @Test
  public void testgetPhotoLabel() throws IOException {
    AddCategoryModel add = new AddCategoryModel();

    assertEquals("Photo:", add.getPhotoLabel());
  }


  @Test
  public void testgetButtonAddLabel() throws Exception {
    AddCategoryModel add = new AddCategoryModel();

    assertEquals("ADD", add.getButtonAddlabel());
  }

//Test examen

  public void testGetImage() throws Exception {
    AuthorsModel authors = new AuthorsModel();
    assertEquals(0, authors.getImage());
  }
//  public void testSetImage()throws Exception{
//    AuthorsModel authors= new AuthorsModel();
//    authors.setImage(R.drawable.wellcome);
//    assertEquals(R.drawable.wellcome,authors.getImage());
//  }

  public void testGetText() throws Exception {
    AuthorsModel authors = new AuthorsModel();
    assertEquals(null, authors.getTxt());
  }

  public void testSetTxt() throws Exception {
    AuthorsModel authors = new AuthorsModel();
    authors.setTxt("autores");
    assertEquals("autores", authors.getTxt());
  }
}