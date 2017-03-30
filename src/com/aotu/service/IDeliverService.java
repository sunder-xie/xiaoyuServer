package com.aotu.service;

import com.aotu.entity.Deliver;
import com.aotu.entity.Page;
import java.util.List;

public abstract interface IDeliverService {
  public abstract void save(Deliver paramDeliver) throws Exception;

  public abstract void delete(String paramString) throws Exception;

  public abstract void update(Deliver paramDeliver) throws Exception;

  public abstract Deliver get(String paramString) throws Exception;

  public abstract Page queryPage(Page paramPage, Deliver paramDeliver) throws Exception;

  public abstract int queryCount(Deliver paramDeliver) throws Exception;

  public abstract List<Deliver> queryList(Deliver paramDeliver) throws Exception;
}