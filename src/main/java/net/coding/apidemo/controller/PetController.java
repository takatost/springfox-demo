package net.coding.apidemo.controller;

import net.coding.apidemo.bean.Pet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = {"宠物"})
@RestController
@RequestMapping("/pets")
public class PetController {

    @ApiOperation(value = "宠物列表", notes = "列出所有宠物信息")
    @GetMapping("")
    public ResponseEntity<List<Pet>> all(@ApiParam(value="限制每页返回数量（最大限制：100）") @RequestParam(required = false, defaultValue = "20") Integer pagesize,
                                         @ApiParam(value="页码") @RequestParam(required = false, defaultValue = "1") Integer page) {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @ApiOperation(value = "宠物详情", notes = "获取指定 ID 的宠物详情")
    @GetMapping("{petId}")
    public ResponseEntity<Pet> detail(@ApiParam(value="宠物 ID", required = true) @PathVariable Integer petId,
                                      @ApiParam(value = "媒体类型", required = true, allowableValues = "application/json,application/xml", defaultValue = "application/json") @RequestHeader String Accept) {
        return ResponseEntity.ok(null);
    }
}
