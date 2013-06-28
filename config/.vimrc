" 设置菜单语言
set langmenu=zh_cn

" ==============
" 功能函数  
" ==============
" 获取当前目录  
func GetPWD()
	return substitute(getcwd(), "", "", "g")
endf

" =============
" 环境配置  
" =============
" 保留历史记录  
set history=500

" 返回当前时间  
func! GetTimeInfo()  
    return strftime('%Y-%m-%d %H:%M:%S')  
endfunction  
  
" 插入模式按 Ctrl + D(ate) 插入当前时间  
imap <C-d> <C-r>=GetTimeInfo()<cr>


" 命令行于状态行  
set ch=1  
set stl=\ [File]\ %F%m%r%h%y[%{&fileformat},%{&fileencoding}]\ %w\ \ [PWD]\ %r%{GetPWD()}%h\ %=\ [Line]\ %l,%c\ %=\ %P   
set ls=2			" 始终显示状态行
set showcmd         " 状态栏显示目前所执行的指令

" 解决gb编码文件乱码
set encoding=utf-8
set fileencodings=utf-8,ucs-bom,gb18030,gbk,gb2312,cp936

set helplang=cn		" 设置中文帮助

syntax enable       " 语法高亮
syntax on
filetype plugin indent on	"打开文件类型检测

set showtabline=2	"显示标签
set cursorline		"高亮光标所在的行

" 行控制  
set linebreak  
set textwidth=80  
set wrap

" 行号和标尺  
set number  
set ruler  
set rulerformat=%15(%c%V\ %p%%%)

" 标签页
set tabpagemax=20
set showtabline=2

" 自动切换到文件当前目录  
set autochdir

" 搜索
set ignorecase      " 在查找时忽略大小写,但在有一个或以上大写字母时仍大小写敏感
set smartcase
set incsearch       " 实时搜索
set hlsearch        " 搜索时高亮显示被找到的文本

" 文件
set history=500		" 保留历史记录
set nobackup		" 无备份
set showmatch		" 显示配对括号
set linespace=2		" 行间距
set mouse=a			" 设定在任何模式下鼠标都可用
set nocompatible	" 不兼容vi模式

" GUI
set guifont=Monaco:h14  " 字体
set lines=120 columns=150
" colorscheme zellner

" 标签
nmap <C-t>   :tabnew<cr>
nmap <C-p>   :tabprevious<cr>
nmap <C-n>   :tabnext<cr>
nmap <C-k>   :tabclose<cr>
nmap <C-Tab> :tabnext<cr> 

noremap <D-M-Left> :tabprevious<cr>
noremap <D-M-Right> :tabnext<cr>

map <D-1> 1gt
map <D-2> 2gt
map <D-3> 3gt
map <D-4> 4gt
map <D-5> 5gt
map <D-6> 6gt
map <D-7> 7gt
map <D-8> 8gt
map <D-9> 9gt
map <D-0> :tablast<CR>

" 格式
set autoindent		" 自动缩进
set smartindent		" 在一个新的语句块之后的行自动缩进到下一个级别

" 关于高亮
:let hs_highlight_delimiters=1            " 高亮定界符
:let hs_highlight_boolean=1               " 把True和False识别为关键字
:let hs_highlight_types=1                 " 把基本类型的名字识别为关键字
:let hs_highlight_more_types=1            " 把更多常用类型识别为关键字
:let hs_highlight_debug=1                 " 高亮调试函数的名字
:let hs_allow_hash_operator=1             " 阻止把#高亮为错误

" 缩进相关的设置
set ts=4			"tabstop    制表符显示的位宽
set sw=4			"shiftwidth 自动缩进时，缩进尺寸为4个空格
set et				"编辑时将所有tab替换为空格
set smarttab		"删除空格时，不用按4次
set softtabstop=4	" 设置按BackSpace的时候可以一次删除掉4个空格
set cindent

" 自动重新读入
set autoread

" 用制表符表示缩进
set noexpandtab

