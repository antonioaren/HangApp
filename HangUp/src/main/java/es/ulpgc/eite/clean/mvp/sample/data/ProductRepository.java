package es.ulpgc.eite.clean.mvp.sample.data;

/**
 * Created by Pedro Arenas on 14/5/17.
 */

public class ProductRepository implements Repository.ProductRepository {


    public void addProduct() {
//        Realm realm = Realm.getInstance(CategoryView.getInstance());
//        realm.beginTransaction();
//       Product realmProduct = realm.createObject(Student.class);
//        realmStudent.setId(UUID.randomUUID().toString());
//        realmStudent.setName(student.getName());
//        realmStudent.setBirthday(student.getBirthday());
//        realmStudent.setEmail(student.getEmail());
//        realm.commitTransaction();
//
//        if (callback != null)
//            callback.onSuccess();
    }

    public void addStudentByUniversityId() {

//        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
//        realm.beginTransaction();
//
//        Student realmStudent = realm.createObject(Student.class);
//        realmStudent.setId(UUID.randomUUID().toString());
//        realmStudent.setName(student.getName());
//        realmStudent.setEmail(student.getEmail());
//        realmStudent.setBirthday(student.getBirthday());
//
//        University university = realm.where(University.class)
//                .equalTo(RealmTable.ID, universityId).findFirst();
//        university.getStudents().add(realmStudent);
//
//        realm.commitTransaction();
//
//        if (callback != null)
//            callback.onSuccess();

    }

    public void deleteStudentById() {
//        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
//        realm.beginTransaction();
//        Student result = realm.where(Student.class).equalTo(RealmTable.ID, id).findFirst();
//        result.removeFromRealm();
//        realm.commitTransaction();
//
//        if (callback != null)
//            callback.onSuccess();
    }

    public void deleteStudentByPosition() {
//        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
//        realm.beginTransaction();
//        RealmQuery<Student> query = realm.where(Student.class);
//        RealmResults<Student> results = query.findAll();
//        results.remove(position);
//        realm.commitTransaction();
//
//        if (callback != null)
//            callback.onSuccess();
    }

    public void getAllStudents() {
//        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
//        RealmResults<Student> results = realm.where(Student.class).findAll();
//
//        if (callback != null)
//            callback.onSuccess(results);
    }

    public void getAllStudentsByUniversityId() {
//        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
//        University university = realm.where(University.class).equalTo(RealmTable.ID, id).findFirst();
//        RealmList<Student> students = university.getStudents();
//
//        if (callback != null)
//            callback.onSuccess(students);

    }

    public void getStudentById() {
//        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
//        Student student = realm.where(Student.class).equalTo(RealmTable.ID, id).findFirst();
//
//        if (callback != null)
//            callback.onSuccess(student);
    }
}
