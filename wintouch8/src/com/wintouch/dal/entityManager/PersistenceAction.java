package com.touchtone.wintouch.dal.entityManager;

import com.touchtone.wintouch.dal.DALException;

public abstract class PersistenceAction {
	
	public final static short ACTION_TYPE_INSERT = 1;
	public final static short ACTION_TYPE_UPDATE = 2;
	public final static short ACTION_TYPE_DELETE = 3;
	public final static short ACTION_TYPE_LOAD = 4;

	protected PersistenceObject po;
	private String actionType;
	

	abstract public ActoinResult execute(EntityManager entityManager);
	

	public Object getActionType() {
		return this.actionType;
	}

	public static PersistenceAction getActionInst(int actionType) {
		
		PersistenceAction result = null;
		
		switch(actionType){
		
			case ACTION_TYPE_INSERT:
				result = new InsertAction();
				break;
			case ACTION_TYPE_UPDATE:
				result = new UpdateAction();
				break;
			case ACTION_TYPE_DELETE:
				result = new DeleteAction();
				break;
			case ACTION_TYPE_LOAD:
				result = new LoadAction();
				break;
			
			default: throw new DALException("Unkown Action type : " + actionType);
		}
		return result;
	}

	public void setPO(PersistenceObject pObj) {
		
		this.po = pObj;
	}

	public PersistenceObject getPO(){
		
		return this.po;
	}
}
