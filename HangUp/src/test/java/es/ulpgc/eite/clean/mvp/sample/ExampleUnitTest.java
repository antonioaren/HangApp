package es.ulpgc.eite.clean.mvp.sample;

import org.junit.Test;

import es.ulpgc.eite.clean.mvp.sample.addCategory.AddCategoryModel;
import es.ulpgc.eite.clean.mvp.sample.category.CategoryModel;
import es.ulpgc.eite.clean.mvp.sample.delete.DeleteModel;
import es.ulpgc.eite.clean.mvp.sample.product.ProductModel;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
  @Test
  public void addition_isCorrect() throws Exception {
    assertEquals(4, 2 + 2);
  }

  //Test for addPartyModel


  // end of TestFor addpartyView3
  //Test for CategoryModel
  @Test
  public void testGetParticipantsAtIndex()throws Exception{
  CategoryModel categoryModel= new CategoryModel();
   int[]numbers= new int[]{1,2,3,4,5};
  int content2= numbers[1];
  assertEquals(content2,categoryModel.getParticipantsAt(1));
}
@Test
  public void testGetSearchLabel(){
  CategoryModel categoryModel= new CategoryModel();
  categoryModel.setSearchLabel("search");
  assertEquals("search",categoryModel.getSearchLabel());
}
  @Test
  public void testGetAddLabel(){
    CategoryModel categoryModel= new CategoryModel();
    categoryModel.setAddLabel("add");
    assertEquals("add",categoryModel.getAddLabel());
  }
  @Test
  public void testGetSearchLabelNull(){
    CategoryModel categoryModel= new CategoryModel();

    assertEquals(null,categoryModel.getSearchLabel());
  }
  @Test
  public void testGetAddLabelNull(){
    CategoryModel categoryModel= new CategoryModel();

    assertEquals(null,categoryModel.getAddLabel());
  }


//test for addcategoryModel
@Test
public void testGetImageByIdSelected()throws Exception{
  AddCategoryModel add= new AddCategoryModel();
 int index= add.getImageByIdSelected(1);
  assertEquals(R.drawable.disco,add.getImageByIdSelected(1));

}
  @Test
  public void testGetImageByIdSelectedOutOfRange()throws Exception{
    AddCategoryModel add= new AddCategoryModel();
    int index= add.getImageByIdSelected(-1);
    assertEquals(R.drawable.astro,index);

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
    add.setLabelRadio0("radio");
    add.setLabelRadio1("radio");
    add.setLabelRadio2("radio");
    add.setLabelRadio3("radio");
    assertEquals("radio",add.getLabelRadio0());
    assertEquals("radio",add.getLabelRadio1());
    assertEquals("radio",add.getLabelRadio2());
    assertEquals("radio",add.getLabelRadio3());
  }


  @Test
  public void testgetPhotoLabelNull(){
    AddCategoryModel add= new AddCategoryModel();

    assertEquals(null,add.getPhotoLabel());
  }

  @Test
  public void testgetPhotoLabelNotNull(){
    AddCategoryModel add= new AddCategoryModel();
    add.setPhotoLabel("photo");
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
   add.setButtonAddlabel("Add");
    assertEquals("Add",add.getButtonAddlabel());
  }

  //test for product model
  @Test
  public void testgetAddLabelWithoutSetting()throws Exception{
    ProductModel product= new ProductModel();
    product.getAddLabel();
    assertEquals(null,product.getAddLabel());
  }
  //Test for DetailModel


  //Test for DetailModel


  //test for DeleteModel

  @Test
  public void testGetDeleteButtonLabelAndDeleteIdBtonLabelWithoutSetting() throws Exception {
    DeleteModel delete = new DeleteModel();
    String label = delete.getDeleteBtnLabel();
    String label2 = delete.getDeleteIdBtnLabel();
    assertEquals(null, label);
    assertEquals(null, label2);
  }

  @Test
  public void testGetDeleteButtonLabelAndDeleteIdBtonLabelBeforeSetting() throws Exception {
    DeleteModel delete = new DeleteModel();
    delete.setDeleteBtnLabel("delete");
    delete.setDeleteIdBtnLabel("delete by Id");
    assertEquals("delete", delete.getDeleteBtnLabel());
    assertEquals("delete by Id", delete.getDeleteIdBtnLabel());
  }
}