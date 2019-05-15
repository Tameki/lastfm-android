package com.geektech.core.realm;

import com.geektech.core.Logger;

import io.realm.Realm;

public abstract class CoreRealmDataSource {
    protected Realm getRealmInstance() {
        return Realm.getDefaultInstance();
    }

    protected void executeTransaction(Realm.Transaction transaction) {
        Realm realm = null;

        try {
            realm = getRealmInstance();
            realm.executeTransaction(transaction);
        } catch (Exception e) {
            Logger.e(e);
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }

    protected long getNextId(Class c) {
        Realm realm = null;

        try {
            realm = getRealmInstance();

            String primaryKeyField = realm.getSchema()
                    .get(c.getSimpleName())
                    .getPrimaryKey();

            Number maxKey = realm.where(c).max(primaryKeyField);

            if (maxKey == null) {
                return 1;
            }

            return maxKey.longValue() + 1;
        } catch (Exception e) {
            Logger.e(e);
            return -1;
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }
}
