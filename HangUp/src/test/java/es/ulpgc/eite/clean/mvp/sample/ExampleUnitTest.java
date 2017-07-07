package es.ulpgc.eite.clean.mvp.sample;

import org.junit.Test;

import java.io.IOException;

import es.ulpgc.eite.clean.mvp.sample.addCategory.AddCategoryModel;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

//test for addcategoryModel
@Test
public void testGetImageByIdSelected()throws Exception{
  AddCategoryModel add= new AddCategoryModel();
    assertEquals("cars.jpeg", add.getImageByIdSelected(3));

}


  @Test
  public void testGetImageByIdSelectedOutOfRange()throws Exception{
    AddCategoryModel add= new AddCategoryModel();
    String index = add.getImageByIdSelected(-1);
      assertEquals(null, index);

  }

  @Test
  public void secondTestGetImageByIdSelectedOutOfRange() throws Exception {
    AddCategoryModel add= new AddCategoryModel();
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
    AddCategoryModel add= new AddCategoryModel();

      assertEquals("Photo:", add.getPhotoLabel());
  }


    @Test
    public void testgetButtonAddLabel() throws Exception {
  AddCategoryModel add= new AddCategoryModel();

        assertEquals("ADD", add.getButtonAddlabel());
}






}