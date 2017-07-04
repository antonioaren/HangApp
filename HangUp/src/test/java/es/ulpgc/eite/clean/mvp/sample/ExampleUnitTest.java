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
    assertEquals("disco.jpg", add.getImageByIdSelected(3));

}


  @Test
  public void testGetCharacterSequenceFromAWord() throws Exception {
    String word = "R.id.r0";
    assertEquals("0", word.substring(6));
  }
  @Test
  public void testGetImageByIdSelectedOutOfRange()throws Exception{
    AddCategoryModel add= new AddCategoryModel();
    String index = add.getImageByIdSelected(-1);
    assertEquals("astro.jpeg", index);

  }
@Test
public void testGetRadioLabelsWithoutSettingName()throws Exception{
  AddCategoryModel add= new AddCategoryModel();
  assertEquals(null,add.getLabelRadio0());
  assertEquals(null,add.getLabelRadio1());
  assertEquals(null,add.getLabelRadio2());
  assertEquals(null,add.getLabelRadio3());
}
  @Test
  public void testGetRadioLabelsBeforeSettingName()throws Exception{
    AddCategoryModel add= new AddCategoryModel();
    add.setLabelRadio0();
    add.setLabelRadio1();
    add.setLabelRadio2();
    add.setLabelRadio3();
    assertEquals("radio",add.getLabelRadio0());
    assertEquals("radio",add.getLabelRadio1());
    assertEquals("radio",add.getLabelRadio2());
    assertEquals("radio",add.getLabelRadio3());
  }


  @Test
  public void testgetPhotoLabelNull() throws IOException {
    AddCategoryModel add= new AddCategoryModel();

    assertEquals(null,add.getPhotoLabel());
  }

  @Test
  public void testgetPhotoLabelNotNull() throws IOException {
    AddCategoryModel add= new AddCategoryModel();
    add.setPhotoLabel();
    assertEquals("photo",add.getPhotoLabel());
  }

  @Test
  public void testgetButtonAddLabelNull(){
  AddCategoryModel add= new AddCategoryModel();

  assertEquals(null,add.getButtonAddlabel());
}
  @Test
  public void testgetButtonAddLabelNotNull(){
    AddCategoryModel add= new AddCategoryModel();
    add.setButtonAddlabel();
    assertEquals("AddProduct", add.getButtonAddlabel());
  }






}