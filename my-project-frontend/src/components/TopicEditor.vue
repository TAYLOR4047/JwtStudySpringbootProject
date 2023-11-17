<script setup>
import {Check, Document} from "@element-plus/icons-vue";
import {reactive} from "vue";
import {QuillEditor} from "@vueup/vue-quill";
import '@vueup/vue-quill/dist/vue-quill.snow.css'

defineProps({
  show: Boolean
})

const emit=defineEmits(['close'])

const editor=reactive({
  type: null,
  title: '',
  text: '',
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
  :close-on-click-modal="false"
  @close="emit('close')">
    <template #header>
      <div>
        <div style="font-weight: bold">发表新的帖子</div>
        <div style="font-size: 13px">发言请友善哦！</div>
      </div>
    </template>
    <div style="display: flex;gap: 10px">
      <div style="width: 150px">
        <el-select placeholder="选择帖子类型" v-model="editor.type">
          <el-option v-for="item in types" :value="item.id" :label="item.name"/>
        </el-select>
      </div>
      <div style="flex: 1">
        <el-input v-model="editor.title" placeholder="请输入帖子标题..." :prefix-icon="Document"/>
      </div>
    </div>
    <div style="margin-top: 15px;height: 460px;overflow: hidden">
      <quill-editor v-model:content="editor.text" style="height: calc(100% - 45px)" placeholder="今天想分享点什么呢？"/>
    </div>
    <div style="display: flex;justify-content: space-between;margin-top: 10px">
      <div style="color: grey;font-size: 13px">
        当前字数
      </div>
      <div>
        <el-button type="success" :icon="Check" plain>立刻发表！</el-button>
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
:deep(.ql-toolbar){
  border-radius: 5px 5px 0 0;
  border-color: var(--el-border-color);
}
:deep(.ql-container){
  border-radius: 0 0 5px 5px;
  border-color: var(--el-border-color);
}
:deep(.ql-editor.ql-blank::before){
  color: var(--el-text-color-placeholder);
  font-style: normal;
}
:deep(.el-editor){
  font-size: 14px;
}
</style>