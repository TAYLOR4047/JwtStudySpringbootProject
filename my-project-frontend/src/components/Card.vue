<script setup>
defineProps({
  icon: Object,
  title: String,
  desc: String
})
</script>

<template>
  <div class="card">
    <div class="card-header" v-if="title">
      <div>
        <el-icon style="margin-right: 3px">
          <component :is="icon"/>
        </el-icon>
        {{title}}
      </div>
      <div>
        <div>{{desc}}</div>
      </div>
    </div>
    <slot/>
  </div>
</template>

<style scoped>
.card{
  border-radius: 5px;
  border: solid 1px var(--el-border-color);
  background-color: var(--el-bg-color);
  box-sizing: border-box;
  min-height: 20px;
  padding: 10px;
/*  实现了slot插槽内文本的自动换行*/
  word-wrap: break-word;
}

.card-header{
  border-bottom: solid 1px var(--el-border-color) ;
  padding-bottom: 5px;
  margin-bottom: 10px;

  &>:first-child{
    font-size: 18px;
    font-weight: bold;
  }
  &>:last-child{
    font-size: 13px;
    color: grey;
  }
}
</style>