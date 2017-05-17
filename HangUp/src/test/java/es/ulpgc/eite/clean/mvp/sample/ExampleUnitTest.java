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

}

}