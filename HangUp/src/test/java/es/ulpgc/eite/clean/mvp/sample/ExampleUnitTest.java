package es.ulpgc.eite.clean.mvp.sample;

import org.junit.Test;

import es.ulpgc.eite.clean.mvp.sample.category.CategoryModel;
import es.ulpgc.eite.clean.mvp.sample.detail.DetailModel;

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
  categoryModel.setSearchLabel();
}
}