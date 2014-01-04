package com.canvass.data;

import com.canvass.data.model.Account;
import com.canvass.data.model.Bill;
import com.canvass.data.model.BillVersion;
import org.hibernate.Session;

import java.util.List;

/**
 * Created By: jordancote
 * Created On: 1/3/14
 */
public interface DataStore {

    public void save(DataModel model);

    public void save(Bill bill, BillVersion billVersion);

    public List<Bill> loadCurrentBills();

    public Session createSession();

    public void closeSession(Session session);

    public void flush();

    public Account loadAccount(Session session, String username);

    public int invalidateWebSessions(Session session, long accountId);

}
