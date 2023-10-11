<script setup>
import Card from "@/components/Card.vue";
import {Message, Notebook, User} from "@element-plus/icons-vue";
</script>

<template>
    <div style="display: flex">
      <div class="settings-left">
        <card :icon="User" title="账号信息设置" desc="在此编辑个人信息">
          <el-form label-position="top" style="margin: 0 10px 10px 10px">
            <el-form-item label="用户名">
              <el-input/>
            </el-form-item>
            <el-form-item label="性别">
              <el-radio-group>
                <el-radio>男</el-radio>
                <el-radio>女</el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="手机号">
              <el-input/>
            </el-form-item>
            <el-form-item label="QQ号">
              <el-input/>
            </el-form-item>
            <el-form-item label="微信号">
              <el-input/>
            </el-form-item>
            <el-form-item label="个人简介">
              <el-input type="textarea" :rows="6"/>
            </el-form-item>
          </el-form>
        </card>

        <card style="margin-top: 10px" :icon="Message" title="电子邮件设置" desc="可以在此修改默认绑定">
          <el-form label-position="top" style="margin: 0 10px 10px 10px">
            <el-form-item label="电子邮件">
              <el-input type="textarea" :rows="6"/>
            </el-form-item>
            <el-form-item label="个人简介">
              <el-row>

              </el-row>
            </el-form-item>
          </el-form>
        </card>
      </div>

      <div class="settings-right">
      </div>
    </div>
</template>

<style scoped>
.settings-left{
  flex: 1;
  margin: 20px;
}

.settings-right{
  width: 300px;
  margin: 20px;
}
</style>