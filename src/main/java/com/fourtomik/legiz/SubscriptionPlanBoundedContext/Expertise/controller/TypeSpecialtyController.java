package com.fourtomik.legiz.SubscriptionPlanBoundedContext.Expertise.controller;

import com.fourtomik.legiz.SubscriptionPlanBoundedContext.Expertise.domain.model.TypeSpecialty;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.Expertise.domain.service.TypeSpecialtyService;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.Expertise.resource.SaveTypeSpecialtyResource;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.Expertise.resource.TypeSpecialtyResource;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TypeSpecialtyController {
    @Autowired
    private TypeSpecialtyService typeSpecialtyService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary="Update Type Specialty", description="Update Type Specialty", tags={"typespecialtys"})
    @PutMapping("/typespecialtys/{typespecialtyId}")
    public TypeSpecialtyResource updateTypeSpecialty(
            @PathVariable Long typespecialtyId,
            @Valid @RequestBody SaveTypeSpecialtyResource resource){
        TypeSpecialty typeSpecialty = convertToEntity(resource);
        return convertToResource(typeSpecialtyService.updateTypeSpecialty(typespecialtyId,typeSpecialty));
    }

    @Operation(summary = "Get All Type Specialty", description = "Get All Type Specialty", tags = {"typespecialtys"})
    @GetMapping("/typespecialtys")
    public Page<TypeSpecialtyResource> getAllTypeSpecialty(Pageable pageable){
        Page<TypeSpecialty> typeSpecialtyPage = typeSpecialtyService.getAllTypeSpecialty(pageable);
        List<TypeSpecialtyResource> resources = typeSpecialtyPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable, resources.size());
    }

    @Operation(summary = "Post Type Specialty", description = "Post Type Specialty", tags = {"typespecialtys"})
    @PostMapping("/typespecialtys")
    public TypeSpecialtyResource createTypeSpecialty(@Valid @RequestBody SaveTypeSpecialtyResource resource){
        TypeSpecialty typeSpecialty = convertToEntity(resource);
        return  convertToResource(typeSpecialtyService.createTypeSpecialty(typeSpecialty));
    }

    @Operation(summary = "Get Type Specialty by Id", description = "Get Type Specialty by Id", tags = {"typespecialtys"})
    @GetMapping("/typespecialtys/{typespecialtyId}")
    public TypeSpecialtyResource getTypeSpecialtyById(@PathVariable Long typespecialtyId){
        return convertToResource(typeSpecialtyService.getTypeSpecialtyById(typespecialtyId));
    }

    @Operation(summary = "Delete Type Specialty", description = "Delete Type Specialty", tags = {"typespecialtys"})
    @DeleteMapping("/typespecialtys/{typespecialtyId}")
    public ResponseEntity<?> deleteTypeSpecialty(@PathVariable Long typespecialtyId) {
        return typeSpecialtyService.deleteTypeSpecialty(typespecialtyId);
    }

    private TypeSpecialty convertToEntity(SaveTypeSpecialtyResource resource){
        return mapper.map(resource, TypeSpecialty.class);
    }

    private TypeSpecialtyResource convertToResource(TypeSpecialty entity){
        return mapper.map(entity, TypeSpecialtyResource.class);
    }
}
