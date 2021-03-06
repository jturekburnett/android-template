/*
 * IndividualQueryManager.java
 *
 * Generated on: 09/17/2014 03:15:27
 *
 */



package org.jdc.template.model.database.main.individualquery;


import org.jdc.template.model.database.DatabaseManager;

import javax.inject.Inject;

@javax.inject.Singleton
public class IndividualQueryManager extends IndividualQueryBaseManager {

    @Inject
    public IndividualQueryManager(DatabaseManager databaseManager) {
        super(databaseManager);
    }

    @Override
    public String getQuery() {
        return IndividualQuery.QUERY;
    }

}