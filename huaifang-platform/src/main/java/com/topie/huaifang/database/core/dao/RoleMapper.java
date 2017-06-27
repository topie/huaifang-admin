package com.topie.huaifang.database.core.dao;

import com.topie.huaifang.common.utils.TreeNode;
import com.topie.huaifang.database.core.model.Role;
import com.topie.huaifang.system.dto.HasRoleUserDTO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface RoleMapper extends Mapper<Role> {

    int insertRoleFunction(@Param("roleId") Integer roleId, @Param("functionId") Integer functionId);

    List<Map> findRoleMatchUpFunctions();

    List<TreeNode> selectRoleTreeNodes(Role role);

    List<Role> findRoleList(Role role);

    List<Integer> findFunctionByRoleId(@Param("roleId") Integer roleId);

    int deleteFunctionByRoleId(@Param("roleId") Integer roleId);

    List<HasRoleUserDTO> findHasRoleUserDtoList(HasRoleUserDTO hasRoleUserDTO);

    void deleteUserRoleRelateByRoleId(Integer id);

    List<Integer> findHasRoleUserIdsByRoleId(@Param("roleId") Integer roleId);

    int selectRoleIdByRoleName(@Param("roleName") String roleName);

    List<TreeNode> selectRoleFunctions(@Param("roleIds")List<Integer> roleIdsList);
}
