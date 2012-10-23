package com.touchtone.wintouch.dal.entityManager;

public abstract class EntityFilter {

	public abstract ActoinResult doFilte(ActoinResult result, Object actionType,PersistenceObject po);
}
