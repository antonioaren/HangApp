package es.ulpgc.eite.clean.mvp.sample.data;

import io.realm.RealmList;
import io.realm.RealmResults;

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

        interface OnSaveProductCallback {

            void onSuccess();
            void onError(String message);
        }

        interface OnDeleteProductCallback {

            void onSuccess();
            void onError(String message);
        }
        interface OnGetProductByIdCallback {

            void onSuccess(ProductData product);
            void onError(String message);
        }

        interface OnGetAllProductsCallback {

            void onSuccess(RealmResults<ProductData> product);
            void onError(String message);
        }

        interface OnGetProductsCallback {

            void onSuccess(RealmList<ProductData> product);
            void onError(String message);
        }

        void addProduct(ProductData product, OnSaveProductCallback callback);

        void addProductByCategoryId(
                ProductData product, String categoryId, OnSaveStudentCallback callback);

        void deleteStudentById(String id, OnDeleteStudentCallback callback);

        void deleteStudentByPosition(int position, OnDeleteStudentCallback callback);

        void getAllStudents(OnGetAllStudentsCallback callback);

        void getAllStudentsByUniversityId(String id, OnGetStudentsCallback callback);

        void getStudentById(String id, OnGetStudentByIdCallback callback);

    }

}

    public interface OnGetAllCategoryCallback {
        void onSuccess(RealmResults<CategoryData> categories);
    }
}
