import { app, BrowserWindow } from "electron";
import { dirname, join } from "path";
import { fileURLToPath } from "url";
const __filename = fileURLToPath(import.meta.url);
const __dirname = dirname(__filename);
function createWindow() {
  const mainWindow = new BrowserWindow({
    width: 1200,
    // 窗口宽度
    height: 800,
    // 窗口高度
    webPreferences: {
      // 网页功能设置
      nodeIntegration: true,
      // 启用Node.js集成（允许在渲染进程中使用Node.js API）
      contextIsolation: false
      // 禁用上下文隔离（与nodeIntegration配合使用）
    }
  });
  if (process.env.NODE_ENV === "development") {
    mainWindow.loadURL("http://localhost:3000");
    mainWindow.webContents.openDevTools();
  } else {
    mainWindow.loadFile(join(__dirname, "../dist/index.html"));
  }
}
app.whenReady().then(createWindow);
app.on("window-all-closed", () => {
  if (process.platform !== "darwin") {
    app.quit();
  }
});
app.on("activate", () => {
  if (BrowserWindow.getAllWindows().length === 0) {
    createWindow();
  }
});
