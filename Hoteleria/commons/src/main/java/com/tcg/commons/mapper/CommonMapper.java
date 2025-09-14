package com.tcg.commons.mapper;

public abstract class CommonMapper<RQ, RS, E> {

    public abstract E requestToEntity(RQ request);

    public abstract RS entityToResponse(E entity);
}
