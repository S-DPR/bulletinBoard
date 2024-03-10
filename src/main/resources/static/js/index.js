window.addEventListener('load', () => {
    // const postListTBody = document.querySelector('#postListTBody')
    const postWrite = document.querySelector('#postWrite')
    const filterText = document.querySelector('#filterText')
    const searchBtn = document.querySelector('#searchBtn')
    const filterType = document.querySelector('#filterType')
    postWrite.addEventListener('click', () => {
        location.href = '/postWrite'
    })
    searchBtn.addEventListener('click', () => {
        const selectedIndex = filterType.selectedIndex
        const selectedOption = filterType.options[selectedIndex]
        location.href = `/?${selectedOption.value}=${filterText.value}`
    })

//     const refreshTable = () => {
//         requestFn(REQUEST_TYPE.GET, "/sys/post/", null, (data) => {
//             data.forEach(data => {
//                 const tr = document.createElement('tr')
//                 tr.dataset.id = data.id
//                 tr.appendChild(createTitleTd(data))
//                 tr.appendChild(createWriterTd(data))
//                 postListTBody.appendChild(tr)
//             })
//         })
//     }
//
//     const createTitleTd = (data) => {
//         const td = createTd()
//         const a = document.createElement('a')
//         a.textContent = data.title
//         a.href = `/${data.id}`
//         td.appendChild(a)
//         return td
//     }
//
//     const createWriterTd = (data) => {
//         const td = createTd()
//         const a = document.createElement('a')
//         a.textContent = data.writer
// //        a.href = `/${data.id}`
//         td.appendChild(a)
//         return td
//     }
//
//     const createTd = () => {
//         const td = document.createElement('td')
//         td.classList.add(...['text-sm', 'text-secondary', 'mb-0'])
//         td.scope = 'col'
//         td.style.textAlign = 'center'
//         return td
//     }
//     refreshTable()
})
