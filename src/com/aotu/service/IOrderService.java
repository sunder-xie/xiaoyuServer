package com.aotu.service;

import com.aotu.entity.Order;
import com.aotu.entity.Page;
import java.util.List;

public abstract interface IOrderService
{
  public abstract void save(Order paramOrder)
    throws Exception;

  public abstract void delete(String paramString)
    throws Exception;

  public abstract void update(Order paramOrder)
    throws Exception;

  public abstract Order get(String paramString)
    throws Exception;

  public abstract Page queryPage(Page paramPage, Order paramOrder)
    throws Exception;

  public abstract List<Order> queryList(Order paramOrder)
    throws Exception;

  public abstract void changeStatus(Order paramOrder)
    throws Exception;
}