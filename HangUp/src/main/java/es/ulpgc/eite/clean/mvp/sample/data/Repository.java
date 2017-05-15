package es.ulpgc.eite.clean.mvp.sample.data;

import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by Pedro Arenas on 14/5/17.
 */

public interface Repository {

    public interface CategoryRepository {


        void DeleteCategoryByPosition(int position, OnDeleteCategoryCallback callback);

        interface OnAddCategoryCallback {

            void onSuccess();
            void onError(String message);
        }

        interface OnGetAllCategoryCallback {

            void onSuccess(RealmResults<CategoryData> categories);
            void onError(String message);
        }

        interface OnGetCategoryByIdCallback {

            void onSuccess(CategoryData category);
            void onError(String message);
        }

        interface OnDeleteCategoryCallback {

            void onSuccess();
            void onError(String message);
        }


        void addCategory(CategoryData category, OnAddCategoryCallback callback);

        void deleteCategoryById(String Id, OnDeleteCategoryCallback callback);

        void deleteCategoryByPosition(int position, OnDeleteCategoryCallback callback);

        void getAllCategories(OnGetAllCategoryCallback callback);

        void getCategoryById(String id, OnGetCategoryByIdCallback callback);


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



        void addProduct(OnSaveProductCallback callback, ProductData product);

        void addProductByCategoryId(
                ProductData product, String categoryId, OnSaveProductCallback callback);

        void deleteProductById(String id, OnDeleteProductCallback callback);

        void deleteProductByPosition(int position, OnDeleteProductCallback callback);

        void getAllProducts(OnGetAllProductsCallback callback);

        void getAllProductsByCategoryId(String id, OnGetProductsCallback callback);

        void getProductsById(String id, OnGetProductByIdCallback callback);

    }




}
