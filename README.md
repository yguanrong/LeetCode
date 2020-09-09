# LeetCode 题目代码和思路
力扣题目的解答

* java文件的类名就是题目的编号和英文名。
* 代码编写采用了idea工具。

#### 下面简单介绍一下如何在idea安装LeetCode插件，以及相关配置的

* 首先在插件市场里面搜索 _leetcode-editor_ 下载安装，然后重启idea即可完成安装

* 其次对插件配置做一些修改，方便我们coding，具体如下：

    先打开settings--》tools --》 LeetCode plus 具体配置如下：
    
    * URL：国内建议选择，leetcode-cn.com
    * code Type ：选择java
    * loginName和password填写LeetCode上的账户和密码
    * tempFilePath：填写文件项目的路径
    
    * 接下来就是对文件名和模板进行修改
    文件名：
    `NO${question.frontendQuestionId}_$!velocityTool.camelCaseName(${question.titleSlug})`
    
    模板：
    
    ${question.content}
    
     package leetcode.editor.cn;
     public class NO${question.frontendQuestionId}_$!velocityTool.camelCaseName(${question.titleSlug}) {
         public static void main(String[] args) {
             Solution solution = 
             new NO${question.frontendQuestionId}_$!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
         }
         
         ${question.code}
     }
