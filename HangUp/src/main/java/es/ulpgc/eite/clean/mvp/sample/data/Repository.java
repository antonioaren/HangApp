package es.ulpgc.eite.clean.mvp.sample.data;

/**
 * Created by Pedro Arenas on 14/5/17.
 */

public interface Repository {

    public interface CategoryRepository {
        void addCategory();

        void DeleteCategoryById();

        void DeleteCategoryByPosition();

        void getCategoryById();

        //void getAllCategories(OnGetAllCategoryCallBack callback);
    }

    public interface ProductRepository {
    }

    public interface OnGetAllCategoryCallback {
    }
}
