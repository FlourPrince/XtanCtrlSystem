/*
 * Copyright (c) 2018-2999 广州市蓝海创新科技有限公司 All rights reserved.
 *
 * https://www.mall4j.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package com.example.xtanctrlsystem.security.admin.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.example.xtanctrlsystem.security.admin.model.SysConfig;
import com.example.xtanctrlsystem.security.admin.service.SysConfigService;
import com.example.xtanctrlsystem.security.common.annotation.SysLog;
import com.example.xtanctrlsystem.security.common.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * 系统配置信息
 * @author lgh
 */
@RestController
@RequestMapping("/sys/config")
public class SysConfigController{
	@Autowired
	private SysConfigService sysConfigService;
	
	/**
	 * 所有配置列表
	 */
	@GetMapping("/page")
	@PreAuthorize("@pms.hasPermission('sys:config:page')")
	public ResponseEntity<IPage<SysConfig>> page(String paramKey, PageParam<SysConfig> page){
		IPage<SysConfig> sysConfigs = sysConfigService.page(page, new LambdaQueryWrapper<SysConfig>().like(StrUtil.isNotBlank(paramKey),SysConfig::getParamKey,paramKey));
		return ResponseEntity.ok(sysConfigs);
	}
	
	
	/**
	 * 配置信息
	 */
	@GetMapping("/info/{id}")
	@PreAuthorize("@pms.hasPermission('sys:config:info')")
	public ResponseEntity<SysConfig> info(@PathVariable("id") Long id){
		SysConfig config = sysConfigService.getById(id);
		return ResponseEntity.ok(config);
	}
	
	/**
	 * 保存配置
	 */
	@SysLog("保存配置")
	@PostMapping
	@PreAuthorize("@pms.hasPermission('sys:config:save')")
	public ResponseEntity<Void> save(@RequestBody @Valid SysConfig config){
		sysConfigService.save(config);
		return ResponseEntity.ok().build();
	}
	
	/**
	 * 修改配置
	 */
	@SysLog("修改配置")
	@PutMapping
	@PreAuthorize("@pms.hasPermission('sys:config:update')")
	public ResponseEntity<Void> update(@RequestBody @Valid SysConfig config){
		sysConfigService.updateById(config);
		return ResponseEntity.ok().build();
	}
	
	/**
	 * 删除配置
	 */
	@SysLog("删除配置")
	@DeleteMapping
	@PreAuthorize("@pms.hasPermission('sys:config:delete')")
	public ResponseEntity<Void> delete(@RequestBody Long[] configIds){
		sysConfigService.deleteBatch(configIds);
		return ResponseEntity.ok().build();
	}

}
