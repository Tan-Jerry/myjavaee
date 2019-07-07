package com.jerry.hrsystem.dao.impl;

import org.springframework.stereotype.Component;

import com.jerry.common.dao.impl.BaseDaoHibernate5;
import com.jerry.hrsystem.dao.PaymentDao;
import com.jerry.hrsystem.domain.Payment;

@Component
public class PaymentDaoHibernate5 extends BaseDaoHibernate5<Payment> implements PaymentDao
{

}
