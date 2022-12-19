package com.bm.relation.model.tree;

import lombok.Data;
import java.util.List;

/**
 * 树形节点.
 *
 * @author : zyg
 * @since : 2022/08/01
 **/
@Data
public class TreeNode {
    private String id;
    private String name;
    private List<TreeNode> children;
}
