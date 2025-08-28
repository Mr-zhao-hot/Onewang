import { app, BrowserWindow } from 'electron'
import { join, dirname } from 'path'
import { fileURLToPath } from 'url'

// 获取当前文件的绝对路径（ES模块中替代__filename）
const __filename = fileURLToPath(import.meta.url)
// 获取当前文件所在的目录路径（ES模块中替代__dirname）
const __dirname = dirname(__filename)

// 创建应用窗口函数
function createWindow() {
  // 创建一个新的浏览器窗口
  const mainWindow = new BrowserWindow({
    width: 1200,           // 窗口宽度
    height: 800,          // 窗口高度
    webPreferences: {     // 网页功能设置
      nodeIntegration: true,        // 启用Node.js集成（允许在渲染进程中使用Node.js API）
      contextIsolation: false       // 禁用上下文隔离（与nodeIntegration配合使用）
    }
  })

  // 判断当前运行环境
  if (process.env.NODE_ENV === 'development') {
    // 开发环境：加载Vite开发服务器的URL
    mainWindow.loadURL('http://localhost:3000')
    // 打开开发者工具（方便调试）
    mainWindow.webContents.openDevTools()
  } else {
    // 生产环境：加载打包后的静态HTML文件
    // join(__dirname, '../dist/index.html') 构建dist目录下的index.html文件的完整路径
    mainWindow.loadFile(join(__dirname, '../dist/index.html'))
  }
}
app.whenReady().then(createWindow)

app.on('window-all-closed', () => {
  if (process.platform !== 'darwin') {
    app.quit()
  }
})

app.on('activate', () => {
  if (BrowserWindow.getAllWindows().length === 0) {
    createWindow()
  }
})
