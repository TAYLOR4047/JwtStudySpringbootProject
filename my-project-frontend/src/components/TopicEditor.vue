<script setup>
import {Document} from "@element-plus/icons-vue";

defineProps({
  show: Boolean
})

const types=[
  {id: 1,name: '日常闲聊',desc: '在这里分享你的日常生活！'},
  {id: 2,name: '游戏交友',desc: '在这里找到你的动物伙伴！'},
  {id: 3,name: '踩坑记录',desc: '拒绝重复掉进同一个坑，告诉大家你的方法吧！'},
]
</script>

<template>
<div>
  <el-drawer :model-value="show"
  direction="btt"
  :size="650"
  :close-on-click-modal="false">
    <template #header>
      <div>
        <div style="font-weight: bold">发表新的帖子</div>
        <div style="font-size: 13px">发言请友善哦！</div>
      </div>
    </template>
    <div style="display: flex;gap: 10px">
      <div style="width: 150px">
        <el-select placeholder="选择帖子类型">
          <el-option v-for="item in types" :value="item.id" :label="item.name">测试</el-option>
        </el-select>
      </div>
      <div style="flex: 1">
        <el-input placeholder="请输入帖子标题..." :prefix-icon="Document"/>
      </div>
    </div>
  </el-drawer>
</div>
</template>

<style scoped>
:deep(.el-drawer){
  width: 800px;
  margin: auto;
  border-radius: 10px 10px 0 0;
}
:deep(.el-drawer__header){
  margin: 0;
}
</style>