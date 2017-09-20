package com.itss.vn.shops.controller;

import com.itss.vn.common.constant.Constants;
import com.itss.vn.common.model.CommonResponse;
import com.itss.vn.common.model.ListResponse;
import com.itss.vn.shops.dto.AccountDTO;
import com.itss.vn.shops.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/v1/account")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
//	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public CommonResponse<AccountDTO> getOneUser(@PathVariable("id") Integer id) {
		log.debug("Received request to list users");
		AccountDTO results = accountService.getOneUser(id);
		CommonResponse<AccountDTO> response = new CommonResponse<AccountDTO>();
		response.successfulRespone(results);
		
		return response;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public CommonResponse<ListResponse<AccountDTO>> getUsers (
			@RequestParam(value = "searchText", required = false) String searchText ) {
		log.debug("Received request to list users");
		ListResponse<AccountDTO> results = accountService.getUsers(searchText);
		CommonResponse<ListResponse<AccountDTO>> response = new CommonResponse<ListResponse<AccountDTO>>();
		response.successfulRespone(results);
		
		return response;
	}



	/*@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public CommonResponse<Integer> createrUsers(@RequestBody @Valid final AccountRequestVo accountRequest) {
		log.info("Received request to create the {}", accountRequest);
		if (accountRequest.getRoleId() == null
				|| accountRequest.getRoleId() <= 0) {
			throw new BadRequestException("Role is null or invalid!");
		}
		Integer result = accountService.addAccount(accountRequest);
		CommonResponse<Integer> response = new CommonResponse<>();
		response.successfulRespone(result);
		return response;
	}*/

}
