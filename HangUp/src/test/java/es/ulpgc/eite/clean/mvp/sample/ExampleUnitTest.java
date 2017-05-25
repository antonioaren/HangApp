package es.ulpgc.eite.clean.mvp.sample;

import org.junit.Test;

import es.ulpgc.eite.clean.mvp.sample.addCategory.AddCategoryModel;
import es.ulpgc.eite.clean.mvp.sample.category.CategoryModel;
import es.ulpgc.eite.clean.mvp.sample.detail.DetailModel;
import es.ulpgc.eite.clean.mvp.sample.search.SearchModel;

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

  //Test for addPartyView
  @Test
  public void testTiltleLabelDetailBeforeCreating()throws Exception{
  DetailModel detail= new DetailModel();
  detail.getTitleLabel();
  assertEquals(null,detail.getTitleLabel());
}
  @Test
  public void testDescriptionLabelDetailBeforeCreating()throws Exception{
    DetailModel detail= new DetailModel();
    detail.getDescriptionLabel();
    assertEquals(null,detail.getTitleLabel());
  }
  @Test
  public void testDateLabelDetailBeforeCreating()throws Exception{
    DetailModel detail= new DetailModel();
    detail.getDateLabel();
    assertEquals(null,detail.getTitleLabel());
  }

  @Test
  public void testHourLabelDetailBeforeCreating()throws Exception{
    DetailModel detail= new DetailModel();
    detail.getHourLabel();
    assertEquals(null,detail.getTitleLabel());
  }

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


}
  @Test
  public void testGetNameCategoryNull(){
   AddCategoryModel add= new AddCategoryModel();
    add.getNamecategory();
    assertEquals(null,add.getNamecategory());
}
  @Test
  public void testGetNameCategoryNotNUll(){
    AddCategoryModel add= new AddCategoryModel();
    add.setNameCategory("name");
    assertEquals("name",add.getNamecategory());
  }
@Test
  public void testgetTitleLabelNull(){
  AddCategoryModel add= new AddCategoryModel();
  add.getTitleLabel();
  assertEquals(null,add.getNamecategory());
}

  @Test
  public void testgetTitleLabelNotNull(){
    AddCategoryModel add= new AddCategoryModel();
    add.setTitleLabel("tilte");
    assertEquals("tilte",add.getNamecategory());
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
  public void testgetButtonPhotoLabelNull(){
  AddCategoryModel add= new AddCategoryModel();

  assertEquals(null,add.getButtonPhotoLabel());
}

  @Test
  public void testgetButtonPhotoLabelNotNull(){
    AddCategoryModel add= new AddCategoryModel();
  add.setButtonPhotoLabel("photo");
    assertEquals("photo",add.getButtonPhotoLabel());
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

  //test for SearchModel
@Test
  public void testgetText1Null(){
  SearchModel search= new SearchModel();
  assertEquals(null,search.getText1Label());

}
  @Test
  public void testgetText2Null(){
    SearchModel search= new SearchModel();
    assertEquals(null,search.getText2Label());

  }
  @Test
  public void testgetText1NotNull(){
    SearchModel search= new SearchModel();
    search.setText1Label("txt");
    assertEquals("text",search.getText1Label());

  }
  @Test
  public void testgetText2NotNull(){
    SearchModel search= new SearchModel();
    search.setText2Label("txt");
    assertEquals("txt",search.getText2Label());

  }

  @Test
  public void testgetButtonDeleteLabelNull(){
    SearchModel search= new SearchModel();

    assertEquals(null,search.getDeleteBtnLabel());

  }
  @Test
  public void testgetButtonDeleteIdLabelNull(){
    SearchModel search= new SearchModel();
    assertEquals(null,search.getDeleteIdBtnLabel());

  }
  @Test
  public void testgetButtonDeleteLabelNotNull(){
    SearchModel search= new SearchModel();
  search.setDeleteBtnLabel("dlt");
    assertEquals("dlt",search.getDeleteBtnLabel());

  }
  @Test
  public void testgetButtonDeleteIdLabelNotNull(){
    SearchModel search= new SearchModel();
    search.setDeleteIdBtnLabel("dlt");
    assertEquals("dlt",search.getDeleteIdBtnLabel());

  }

}