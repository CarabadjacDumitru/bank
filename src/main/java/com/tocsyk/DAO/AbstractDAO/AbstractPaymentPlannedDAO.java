package com.tocsyk.DAO.AbstractDAO;

import com.tocsyk.model.PaymentPlanned;
import java.util.List;

public interface AbstractPaymentPlannedDAO {
     List<PaymentPlanned> findAllPaymentPlanned();
     int registerPaymentPlanned(PaymentPlanned paymentPlanned);
     PaymentPlanned loadPaymentPlannedData(int payment);
}
