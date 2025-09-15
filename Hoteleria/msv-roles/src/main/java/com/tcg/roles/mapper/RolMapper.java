package com.tcg.roles.mapper;

import org.springframework.stereotype.Component;

import com.tcg.commons.dto.RolRequest;
import com.tcg.commons.dto.RolResponse;
import com.tcg.commons.mapper.CommonMapper;
import com.tcg.roles.model.Rol;

@Component
public class RolMapper extends CommonMapper<RolRequest, RolResponse, Rol> {

    @Override
    public Rol requestToEntity(RolRequest request) {
        Rol rol = new Rol();
        rol.setNombre(request.nombre().trim());
        return rol;
    }

    @Override
    public RolResponse entityToResponse(Rol entity) {
        return new RolResponse(entity.getId(), entity.getNombre());
    }
}
